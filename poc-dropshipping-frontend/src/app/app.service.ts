import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { environment } from '../environments/environment';
import 'rxjs/add/operator/map';
import { Usuario } from './model/usuario.model';
import { ItemCarrinho } from './model/item-carrinho.model';

@Injectable()
export class AppService {

    private URL = '';
    private CATALAGO = 'catalogo';
    private CARRINHO = 'carrinho';
    private PEDIDO = 'pedido';

    constructor(private http: Http) {
        this.URL = environment.URL_API;
    }

    private getHeader(): RequestOptions {
        const token = this.currentUserValue()['token'];
        let headers = new Headers({ 'Content-Type': 'application/json' });
        headers.append('Authorization', 'Bearer ' + token)
        return new RequestOptions({ headers: headers });
    }

    /**
     * Catalago
     */

    /* Lista os produtos disponiveis para venda. */
    public catalogo() {
        return this.http.get(`${this.URL}/${this.CATALAGO}/listar/`).map(res => res.json());;
    }

    /** Consulta um produto por descrição. */
    public consultarProdutoPorDescricao(descricao: string) {
        return this.http.get(`${this.URL}/${this.CATALAGO}/descricao/${descricao}`).map(res => res.json());;
    }

    /** Consulta um produto por ID */
    public consultarProdutoPorCodigo(id: number) {
        return this.http.get(`${this.URL}/${this.CATALAGO}/codigo/${id}`).map(res => res.json());;
    }

    /**
     * Carrinho
     */

    /** Lista os itens no carrinho do cliente logado. */
    public listarItensCarrinho() {
        return this.http.get(`${this.URL}/${this.CARRINHO}/listar`, this.getHeader()).map(res => res.json());
    }

    /** Inclui um produto no carrinho do cliente logado. */
    public incluirProduto(item: ItemCarrinho) {
        return this.http.post(`${this.URL}/${this.CARRINHO}/incluir`, item, this.getHeader());
    }

    /** Remove o produto do carrinho do cliente logado. */
    public removerProduto(item: ItemCarrinho) {
        return this.http.post(`${this.URL}/${this.CARRINHO}/remover`, item, this.getHeader());
    }

    /** Finaliza os itens no carrinho do cliente gerando o pedido de compra.*/
    public finalizarCarrinho() {
        return this.http.get(`${this.URL}/${this.CARRINHO}/checkout`, this.getHeader());
    }

    /**
     * Meus pedidos
     */

    /** Lista todos os pedidos realizados pelo cliente logado. */
    public listarPedidos() {
        return this.http.get(`${this.URL}/${this.PEDIDO}/listarPedidos`, this.getHeader()).map(res => res.json());
    }

    /** Lista um pedido por codigo. */
    public consultarDetalhePedido(codigo: string) {
        return this.http.get(`${this.URL}/${this.PEDIDO}/listarPedido/${codigo}`, this.getHeader()).map(res => res.json());
    }

    /** Realiza o chechout de um pedido aberto. */
    public finalizarPedido(codigo: string) {
        return this.http.post(`${this.URL}/${this.PEDIDO}/finalizarPedido`, { codigo: codigo }, this.getHeader());
    }

    /**
     * Login Services
     */

    public currentUserValue() {
        const user = localStorage.getItem('pucCurrentUser');
        return user ? JSON.parse(user) : undefined;
    }

    public logout() {
        localStorage.removeItem('pucCurrentUser');
    }

    public isLogged() {
        return localStorage.getItem('pucCurrentUser') != undefined;
    }

    public setUser(response: any) {
        const user = response['_body'];
        localStorage.setItem('pucCurrentUser', user);
    }

    public registrar(user: Usuario) {
        return this.http.post(`${this.URL}/usuario/registrar`, user, {});
    }

    public autenticar(user: Usuario) {
        return this.http.post(`${this.URL}/login`, user, {});
    }
}
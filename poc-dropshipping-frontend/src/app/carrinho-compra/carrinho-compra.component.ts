import { Component, OnInit } from '@angular/core';
import { ItemCatalogo } from 'app/model/item-catalogo.model';
import { AppService } from 'app/app.service';
import { ItemCarrinho } from 'app/model/item-carrinho.model';
import Swal, { SweetAlertType } from 'sweetalert2';

@Component({
  selector: 'ds-carrinho-compra',
  templateUrl: './carrinho-compra.component.html',
})
export class CarrinhoCompraComponent implements OnInit {

  itemCatalogo: ItemCatalogo;
  public carrinho: ItemCarrinho[];
  public frete = 34;
  public totalCarrinho = 0;

  constructor(private service: AppService) { }

  ngOnInit() {
    this.listar();
  }

  public listar() {
    this.carrinho = [];
    this.totalCarrinho = 0;
    this.service.listarItensCarrinho().subscribe(resp => {
      this.carrinho = resp;
      this.carrinho.forEach(item => this.totalCarrinho += item.produto.vlrVenda);
    });
  }

  public concluirPedido() {
    this.service.finalizarCarrinho().subscribe(resp => {
      this.listar();
      this.mensagem('Pedido Gerado ' + resp['_body'], '' , 'success');
    }, err => {
      this.mensagem('Ooops...', 'Não foi possível finalizar o carrinho.', 'error');
    });
  }

  public removerItem(id: any) {
    this.service.removerProduto(new ItemCarrinho({ id: id })).subscribe(data => {
      this.listar();
    }, err => {
      this.mensagem('Ooops...', 'Não foi possível remover o produto no carrinho.', 'error');
    });
  }

  private mensagem(title = '', message: string, type: SweetAlertType) {
    Swal.fire({ title: title, text: message, type: type, confirmButtonText: 'OK' })
  }

}

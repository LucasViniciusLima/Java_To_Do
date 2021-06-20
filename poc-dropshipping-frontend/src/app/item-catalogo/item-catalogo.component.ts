import { Component, OnInit, Input } from '@angular/core';
import { ItemCatalogo } from '../model/item-catalogo.model';
import { AppService } from 'app/app.service';
import Swal, { SweetAlertType } from 'sweetalert2';
import { ItemCarrinho } from 'app/model/item-carrinho.model';

@Component({
  selector: 'ds-item-catalogo',
  templateUrl: './item-catalogo.component.html'
})
export class ItemCatalogoComponent implements OnInit {

  @Input() item: ItemCatalogo
  public quantidade = 1;

  constructor(private service: AppService) { }

  ngOnInit() {
  }

  public isUsuarioLogado() {
    return this.service.isLogged();
  }

  public incluirItemNoCarrinho() {
    const produto = new ItemCarrinho({
      quantidade: this.quantidade,
      produto: this.item
    });

    this.service.incluirProduto(produto).subscribe(data => {
      this.mensagem('Carrinho', 'Incluido no carrinho.', 'info');
    }, err => {
      this.mensagem('Ooops...', 'Não foi possível incluir o produto no carrinho.', 'error');
    });
  }

  private mensagem(title = '', message: string, type: SweetAlertType) {
    Swal.fire({ title: title, text: message, type: type, confirmButtonText: 'OK' })
  }

}

import { Component, OnInit } from '@angular/core';
import { AppService } from 'app/app.service';
import { Pedido } from 'app/model/pedido.mode';

@Component({
    selector: 'app-pedidos',
    styleUrls: ['pedidos.component.css'],
    templateUrl: 'pedidos.component.html'
})
export class PedidosComponent implements OnInit {

    public pedidos: Pedido[];

    constructor(private service: AppService) { }

    ngOnInit() {
      this.listar();
    }
  
    public listar() {
      this.pedidos = [];
      this.service.listarPedidos().subscribe(resp => {
        this.pedidos = resp;
      });
    }

}
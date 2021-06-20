import { Component, OnInit } from '@angular/core';
import { ItemCatalogo } from '../model/item-catalogo.model';
import { AppService } from 'app/app.service';

@Component({
  selector: 'ds-catalogo',
  templateUrl: './catalogo.component.html',
})
export class CatalogoComponent implements OnInit {

  public catalogo: ItemCatalogo[];

  constructor(private service: AppService) { }

  ngOnInit() {
    this.service.catalogo().subscribe(catalogo => this.catalogo = catalogo);
  }

}

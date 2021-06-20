import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { ROUTES } from './app.routes'
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AboutComponent } from './about/about.component';
import { FormsModule } from '@angular/forms';
import { InputComponent } from './shared/input/input.component';
import { RadioComponent } from './shared/radio/radio.component';
import { RatingComponent } from './shared/rating/rating.component';
import { CatalogoComponent } from './catalogo/catalogo.component';
import { ItemCatalogoComponent } from './item-catalogo/item-catalogo.component';
import { CarrinhoCompraComponent } from './carrinho-compra/carrinho-compra.component';
import { AppService } from './app.service';
import { CadastroComponent } from './cadastro-cliente/cadastro-cliente.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { PedidosComponent } from './pedidos/pedidos.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AboutComponent,
    InputComponent,
    RadioComponent,
    RatingComponent,
    CatalogoComponent,
    ItemCatalogoComponent,
    CarrinhoCompraComponent,
    CadastroComponent,
    PedidosComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(ROUTES),
    FormsModule,
  ],
  providers: [
    AppService,
    { provide: LOCALE_ID, useValue: 'pt-BR' },
    AuthGuard,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

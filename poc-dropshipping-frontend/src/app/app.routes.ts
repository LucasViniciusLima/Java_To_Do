import { Routes } from "@angular/router";
import { AboutComponent } from "./about/about.component";
import { CatalogoComponent } from "./catalogo/catalogo.component";
import { CarrinhoCompraComponent } from "./carrinho-compra/carrinho-compra.component";
import { LoginComponent } from "./login/login.component";
import { CadastroComponent } from "./cadastro-cliente/cadastro-cliente.component";
import { AuthGuard } from "./guards/auth.guard";
import { PedidosComponent } from "./pedidos/pedidos.component";

export const ROUTES: Routes = [
    { path: '', redirectTo: 'catalogo', pathMatch: 'full' },
    { path: 'sobre', component: AboutComponent },
    { path: 'catalogo', component: CatalogoComponent },
    { path: 'carrinho', canActivate: [AuthGuard], component: CarrinhoCompraComponent },
    { path: 'pedidos', canActivate: [AuthGuard], component: PedidosComponent },
    { path: 'login', component: LoginComponent },
    { path: 'cadastro', component: CadastroComponent },
];
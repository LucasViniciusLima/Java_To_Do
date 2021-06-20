import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AppService } from 'app/app.service';
import Swal, { SweetAlertType } from 'sweetalert2';
import { Usuario } from 'app/model/usuario.model';

@Component({
    selector: 'app-login',
    styleUrls: ['login.component.css'],
    templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {

    public username = '';
    public password = '';

    constructor(private router: Router, private service: AppService) {
        if (this.service.currentUserValue()) {
            this.router.navigate(['/']);
        }
    }

    ngOnInit() { }

    public login() {
        if (!this.password && !this.username) {
            this.mensagem('Informe Usuário e Senha', 'error');
            return;
        }
        this.autenticar();
    }

    private autenticar() {
        this.service.autenticar(new Usuario({ email: this.username, senha: this.password })).subscribe(data => {
            this.service.setUser(data);
            this.router.navigate(['/']);
        }, err => {
            this.mensagem('Login inválido.', 'error');
        });
    }

    private mensagem(message: string, type: SweetAlertType) {
        Swal.fire({ title: 'Oops...', text: message, type: type, confirmButtonText: 'OK' })
    }
}
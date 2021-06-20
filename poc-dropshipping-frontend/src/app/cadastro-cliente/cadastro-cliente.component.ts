import { Component, OnInit } from '@angular/core';
import { AppService } from 'app/app.service';
import { Usuario } from 'app/model/usuario.model';
import Swal, { SweetAlertType } from 'sweetalert2';

@Component({
    selector: 'app-cadastro-cliente',
    styleUrls: ['cadastro-cliente.component.css'],
    templateUrl: 'cadastro-cliente.component.html'
})
export class CadastroComponent implements OnInit {

    public QUANTIDADE_CAMPOS_OBRIGATORIOS = 13;
    public usuario: Usuario = new Usuario();

    constructor(private service: AppService) { }

    ngOnInit() { }

    public salvar() {
        let qtdCamposPreenchidos = 0;
        for (let i in this.usuario) {
            if (this.usuario[i])
                qtdCamposPreenchidos += 1;
        }

        if (qtdCamposPreenchidos === this.QUANTIDADE_CAMPOS_OBRIGATORIOS) {
            this.registrar();
        } else {
            this.mensagem('Validação', 'Preencha os campos obrigatórios.', 'warning');
        }
    }

    private registrar() {
        this.service.registrar(this.usuario).subscribe(data => {
            this.service.setUser(data);
            this.mensagem(undefined, 'Cadastro realizado com sucesso!', 'success');
        }, err => {
            this.mensagem('Ooops...', 'Login inválido.', 'error');
        });
    }

    private mensagem(title = '', message: string, type: SweetAlertType) {
        Swal.fire({ title: title, text: message, type: type, confirmButtonText: 'OK' })
    }
}
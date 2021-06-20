export class Usuario {

    public id: string;
    // Dados do Login
    public email: string;
    public senha: string;
    // Dados Cadastrais
    public nome: string;
    public dataNascimento: string;
    public sexo: string;
    public telefone: string;
    public cpf: string;
    // Endereço
    public rua: string;
    public numero: number;
    public bairro: string;
    public cidade: string;
    public estado: string;
    public cep: string;

    constructor(values: object = {}) {
        Object.assign(this, values);
    }
}
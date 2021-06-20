export class Pedido {

    public id: string;
    public codigo: string;
    public statusPedido: string;
    public total: number;

    constructor(values: object = {}) {
        Object.assign(this, values);
    }
}
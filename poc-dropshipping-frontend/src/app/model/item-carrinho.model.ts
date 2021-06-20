import {ItemCatalogo} from './item-catalogo.model'

export class ItemCarrinho {

    public id: string
	public quantidade: number;
	public produto: ItemCatalogo;

    constructor(values: object = {}) {
        Object.assign(this, values);
    }
} 
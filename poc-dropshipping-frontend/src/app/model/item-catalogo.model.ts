export class ItemCatalogo {

    public id: string
    public name: string
    public vlrVenda: number
    public category: string
    public about: string
    public rating: number
    public image: string

    constructor(values: object = {}) {
        Object.assign(this, values);
    }
}
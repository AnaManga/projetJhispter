export interface IGroup {
    id?: number;
    nom?: string;
}

export class Group implements IGroup {
    constructor(public id?: number, public nom?: string) {
        this.id = id ? id : null;
        this.nom = nom ? nom : null;
    }
}

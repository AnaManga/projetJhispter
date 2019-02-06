export interface IGroup {
    id?: number;
    nom?: string;
    authorities?: any[];
}

export class Group implements IGroup {
    constructor(public id?: number, public nom?: string, public authorities?: any[]) {
        this.id = id ? id : null;
        this.nom = nom ? nom : null;
        this.authorities = authorities ? authorities : null;
    }
}

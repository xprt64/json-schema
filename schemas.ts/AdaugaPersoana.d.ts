/** D:\gica\github\xprt64\json-schema\schemas\ceva\command\AdaugaPersoana.schema.json  */

export type Stare = "ACTIVAT" | "DEACTIVAT";

export interface AdaugaPersoana {
  id: string;
  numeComplet: NumeComplet;
  stare?: Stare;
}
export interface NumeComplet {
  nume: string;
  prenume?: string;
}

/** D:\gica\github\xprt64\json-schema\schemas\altceva\event\PersoanaAFostAdaugata.schema.json  */

export type Stare = "ACTIVAT" | "DEACTIVAT";

export interface PersoanaAFostAdaugata {
  id: string;
  numeComplet: NumeComplet;
  stare?: Stare;
}
export interface NumeComplet {
  nume: string;
  prenume?: string;
}

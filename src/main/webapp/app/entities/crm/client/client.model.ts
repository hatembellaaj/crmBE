export interface IClient {
  id?: number;
  designation?: string | null;
  contact?: string | null;
  postec?: string | null;
  email?: string | null;
  tel?: string | null;
  adresse?: string | null;
  besoins?: string | null;
  remarques?: string | null;
  forum?: string | null;
}

export class Client implements IClient {
  constructor(
    public id?: number,
    public designation?: string | null,
    public contact?: string | null,
    public postec?: string | null,
    public email?: string | null,
    public tel?: string | null,
    public adresse?: string | null,
    public besoins?: string | null,
    public remarques?: string | null,
    public forum?: string | null
  ) {}
}

export function getClientIdentifier(client: IClient): number | undefined {
  return client.id;
}

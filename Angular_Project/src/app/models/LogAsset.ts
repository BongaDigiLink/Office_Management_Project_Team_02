export class LogAsset
{
        id?:number;
        asset_name?: string;
        from_date?: string;
        to_date?: string;
        notes?: string;
        log_status?: string;
        reason?: string;

}

export class logdtoAsset
{
    constructor(
        asset_name: string,
        from_date: string,
        to_date: string,
        notes: string,
        log_status: string,
        reason: string,
    ){}
}
export class LogAsset
{
        id?:number;
        admin_user?: string;
        candidate_name?: string;
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
        candidate_name : string,
        asset_name: string,
        from_date: string,
        to_date: string,
        notes: string,
        log_status: string,
        reason: string,
    ){}
}
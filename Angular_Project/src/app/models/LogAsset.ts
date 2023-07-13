export class LogAsset
{
        id?:number;
        adminUser?: string;
        candidateName?: string;
        assetName?: string;
        fromDate?: string;
        toDate?: string;
        notes?: string;
        logStatus?: string;
        reason?: string;
}

export class logdtoAsset 
{
    constructor(
        candidateName : string,
        assetName: string,
        fromDate: string,
        toDate: string,
        notes: string,
        logStatus: string,
        reason: string,
    ){}
}
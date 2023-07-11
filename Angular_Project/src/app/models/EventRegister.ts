export class EventRegister
{
    user_email?: string; //use this for candidate_id
    time?: string;
    event_name?: string; //use this for event_id
    event_message?: string | undefined; //Column - Event

    //incoming Data
    event_id?: number;
    candidate_name?: string;
}
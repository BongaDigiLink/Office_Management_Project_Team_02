import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-cheader',
  templateUrl: './cheader.component.html',
  styleUrls: ['./cheader.component.css']
})
export class CheaderComponent implements OnInit{

  constructor(private authservice: AuthService){}

  headerView: boolean = false;

  ngOnInit(): void {
    this.authservice.signedIn$.subscribe( (status) =>
    {
      this.headerView = status;
    } );
  }
}

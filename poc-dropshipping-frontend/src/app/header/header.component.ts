import { Component, OnInit } from '@angular/core';
import { AppService } from 'app/app.service';
import { Router } from '@angular/router';

@Component({
  selector: 'ds-header',
  templateUrl: './header.component.html',
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private service: AppService) { }

  ngOnInit() {}

  public logout() {
    this.service.logout();
    this.router.navigate(['/']);
  }

  public isUsuarioLogado() {
    return this.service.isLogged();
  }

}

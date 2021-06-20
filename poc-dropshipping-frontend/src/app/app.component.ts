import {Component, OnInit} from "@angular/core"

@Component({
  selector: 'ds-app',
  templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {

  content = 'Bem vindo ao Ds-PUC!'

  constructor() { }

  ngOnInit() {
  }

}

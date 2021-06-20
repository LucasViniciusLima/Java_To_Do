import { Component, OnInit, Input, ContentChild } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'ds-input-container',
  templateUrl: './input.component.html',
})
export class InputComponent implements OnInit {

  input: any
  @Input() label: string
  @Input() errorMessage: string

  @ContentChild(NgModel) model: NgModel

  constructor() { }

  ngOnInit() {
  }

  ngAfterContentInit(){
    this.input = this.model
    if(this.input === undefined){
      throw new Error ('Esse componente precisa ser usado com uma diretiva ngModel')
    }
  }
  hasSuccess(): boolean{

    return this.input.valid && (this.input.dirty || this.input.touched)
  }
  hasError(): boolean{
    
    return this.input.invalid && (this.input.dirty || this.input.touched)

  }
}

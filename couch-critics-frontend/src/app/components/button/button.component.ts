import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.sass']
})
export class ButtonComponent implements OnInit {
  //properties 
  @Input() text!: string; 
  @Input() color!: string; 
  constructor() { }

  ngOnInit(): void {
  }

}

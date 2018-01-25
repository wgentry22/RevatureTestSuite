import { Component, OnInit } from '@angular/core';
import { testObject } from '../testObject';
import { mockArray } from '../mockArray';
//import { testService } from 'somewhere';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {
  allTests: Array<testObject> = mockArray;
  
  groups: Array<String> = ["VP","Trainer","Unit"];

  constructor(/*testService*/) { }

  ngOnInit() {
  }

}

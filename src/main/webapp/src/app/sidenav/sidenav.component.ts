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
  tests: Array<testObject> = mockArray;

  constructor(/*testService*/) { }

  ngOnInit() {
  }

}

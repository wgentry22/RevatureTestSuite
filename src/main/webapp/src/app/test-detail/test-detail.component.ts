import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { testObject } from '../testObject';
import { mockArray } from '../mockArray';
// import { testService } from 'somewhere';

@Component({
  selector: 'app-test-detail',
  templateUrl: './test-detail.component.html',
  styleUrls: ['./test-detail.component.css']
})
export class TestDetailComponent implements OnInit {
  private test: testObject;

  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    console.log("do check...");
    this.showTest();
  }

  showTest(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.test = mockArray[id-1];
  }
}

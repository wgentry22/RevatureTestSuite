import { Component, OnInit } from '@angular/core';
import { jsonObject } from '../jsonObject';
import { TestService } from '../test.service';

@Component({
  selector: 'app-metrics-view',
  templateUrl: './metrics-view.component.html',
  styleUrls: ['./metrics-view.component.css']
})
export class MetricsViewComponent implements OnInit {
  testData: any;

  initializeChart() {
    // create a pie chart
  }

  constructor(public ts : TestService) { }

  ngOnInit() {
    console.log("initializing tests-overview");
    this.ts.getTestData().subscribe(data => {
      this.testData = data;
    });
    this.initializeChart();
  }

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tests-overview',
  templateUrl: './tests-overview.component.html',
  styleUrls: ['./tests-overview.component.css']
})
export class TestsOverviewComponent implements OnInit {
  allTestsPassed: Boolean = false;
  testStatus: String = 'Failed build';
  btnIsDisabled: Boolean = false;
  runAllTests: Object = function() {
    console.log("disabling...");
    this.btnIsDisabled = true;
    let timeout = setTimeout(() => {
      console.log("enabling...");
      this.btnIsDisabled = false;
    }, 3000); // wait five second
  }

  constructor() { }

  ngOnInit() {
  }

}

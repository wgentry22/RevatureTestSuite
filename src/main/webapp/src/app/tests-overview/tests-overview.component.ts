import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientJsonpModule } from '@angular/common/http';
import { jsonObject } from '../jsonObject';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-tests-overview',
  templateUrl: './tests-overview.component.html',
  styleUrls: ['./tests-overview.component.css']
})
export class TestsOverviewComponent implements OnInit {
  allTestsPassed: Boolean = false;
  testStatus: String = 'No tests run yet';
  btnIsDisabled: Boolean = false;

  testData: jsonObject;

  errMsg: String;

  runAllTests: Object = function() {
    console.log("disabling button...");
    this.btnIsDisabled = true;
    console.log("running tests and fetching all test data:");
    //const url = "http://localhost:8080/RevatureTestSuite/GetAllTests?output=json&callback=JSONP_CALLBACK";
    const url = "http://localhost:8080/RevatureTestSuite/GetAllTests";
    this.http.get(url).subscribe(data => {
      this.errMsg = "";
      console.log(data);
      this.testData = data;
      console.log("enabling button...");
      this.btnIsDisabled = false;
      (data.totalNumTests == data.numSuccessfulTests && data.totalNumTests!=0) ? this.allTestsPassed = true : this.allTestsPassed = false;
      this.allTestsPassed ? this.testStatus = "All tests passed!" : this.testStatus = "Some tests failed";
    },
    err => {
      console.log(err);
      this.errMsg = "Unable to get test data";
      if (err.error instanceof Error) {
        console.log("Client-side error occured.");
      } else {
        console.log("Server-side error occured.");
      }
    });
  }

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
  }

}

import { Component, OnInit, OnChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { testObject } from '../testObject';
import { groupObject } from '../groupObject';
import { mockArray } from '../mockArray';

@Component({
  selector: 'app-group-detail',
  templateUrl: './group-detail.component.html',
  styleUrls: ['./group-detail.component.css']
})
export class GroupDetailComponent implements OnInit {
  private tests: Array<testObject> = mockArray;
  private group: groupObject = new groupObject();

  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    this.showGroup();
  }

  showGroup(): void {
    const name = this.route.snapshot.paramMap.get('groupname');
    this.group.name = name;
    this.group.tests = this.filterTestsByGroup(this.tests,name);
  }

  filterTestsByGroup(tests: Array<testObject>,groupName: string): Array<testObject> {
    let filteredTests = new Array<testObject>();
    let index=0;
    for (let i=0;i<tests.length;i++) {
      if (tests[i].groups.includes(groupName)) {
        filteredTests[index]=tests[i];
        index++;
      }
    }
    return filteredTests;
  }

}

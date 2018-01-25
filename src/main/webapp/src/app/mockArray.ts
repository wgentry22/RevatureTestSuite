import {testObject} from './testObject';
export const mockArray: Array<testObject> = [
  {
    id: 1,
    name: "Test for both VP and Trainer",
    groups: ["VP","Trainer"]
  },
  {
    id: 2,
    name: "Unit test for VP",
    groups: ["VP","Unit"]
  },
  {
    id: 3,
    name: "Unit test for Trainer",
    groups: ["Trainer","Unit"]
  }
];

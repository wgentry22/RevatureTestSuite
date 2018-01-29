import {testObject} from './testObject';
export const mockArray: Array<testObject> = [
  {
    id: 1,
    name: "Test for both VP and Trainer",
    groups: ["VP","Trainer"],
    belongsToClass: "exampleClass1",
    exceptionThrown: "sample exception"
  },
  {
    id: 2,
    name: "Unit test for VP",
    groups: ["VP","Unit"],
    belongsToClass: "exampleClass1",
    exceptionThrown: "sample exception"
  },
  {
    id: 3,
    name: "Unit test for Trainer",
    groups: ["Trainer","Unit"],
    belongsToClass: "exampleClass1",
    exceptionThrown: "sample exception"
  }
];

import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestsOverviewComponent } from './tests-overview/tests-overview.component';
import { TestDetailComponent } from './test-detail/test-detail.component';

const routes: Routes = [
  { path: 'overview', component: TestsOverviewComponent },
  { path: 'tests/:id', component:  TestDetailComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

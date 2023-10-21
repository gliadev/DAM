import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'tab4',
    pathMatch: 'full',
  },
  {
    path: 'tab1',
    loadChildren: () =>
      import('./tabs/tab1/tab1.module').then((m) => m.Tab1PageModule),
  },
  {
    path: 'tab2',
    loadChildren: () =>
      import('./tabs/tab2/tab2.module').then((m) => m.Tab2PageModule),
  },
  {
    path: 'tab3',
    loadChildren: () =>
      import('./tabs/tab3/tab3.module').then((m) => m.Tab3PageModule),
  },
  {
    path: 'tab4',
    loadChildren: () =>
      import('./tabs/tab4/tab4.module').then((m) => m.Tab4PageModule),
  },
  {
    path: 'tab5',
    loadChildren: () =>
      import('./tabs/tab5/tab5.module').then((m) => m.Tab5PageModule),
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}

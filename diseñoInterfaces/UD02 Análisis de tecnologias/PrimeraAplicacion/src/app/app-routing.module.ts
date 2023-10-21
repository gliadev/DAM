import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

// Funciones que se usan para el loadChildren de la ruta "home"
function callback(m) { 
  return m.HomePageModule
}

function unaFuncion() {
  return import('./pages/home/home.module').then( callback )
}

// Se definen los paths de las diferentes páginas de la aplicación
const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule)

    // Diferentes maneras de escribir la línea anterior. Con funciones lambda, anónimas o normales
    // loadChildren: function() { return import('./home/home.module').then( m => m.HomePageModule) }
    // loadChildren: function() { return import('./home/home.module').then( function(m) { return m.HomePageModule } ) }
    // loadChildren: function() { return import('./home/home.module').then( callback ) }    
    // loadChildren:  unaFuncion
  },
  {
    path: '',
    redirectTo: 'pagina2',
    pathMatch: 'full'
  },
  {
    path: 'pagina1',
    loadChildren: () => import('./pages/pagina1/pagina1.module').then( m => m.Pagina1PageModule)
  },
  {
    path: 'pagina2',
    loadChildren: () => import('./pages/pagina2/pagina2.module').then( m => m.Pagina2PageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

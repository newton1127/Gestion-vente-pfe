import { Component } from '@angular/core';
import {Catalog} from "../../models/catalog.model";
import {CatalogService} from "../../services/catalog.service";

@Component({
  selector: 'app-catalogs',
  templateUrl: './catalogs.component.html',
  styleUrls: ['./catalogs.component.css']
})
export class CatalogComponent {
  catalogs: Catalog[]=[];
  selectedCatalog?: Catalog;
  editCatalog?: Catalog;
  newCatalog: Catalog={ id: 0, Libelle: '', products: [] };


  constructor(private catalogService: CatalogService) { }

  ngOnInit() {
    this.reloadData();this.selectedCatalog = new Catalog(0,"",[]);

  }

  reloadData() {
    this.catalogService.getCatalogsList()
      .subscribe(data => {
        this.catalogs = data;
      });
  }

  onSelect(catalog: Catalog): void {
    this.selectedCatalog = catalog;
  }

  onEdit(catalog: Catalog): void {
    this.editCatalog = catalog;
  }

  onDelete(catalog: Catalog): void {
    this.catalogService.deleteCatalog(catalog.id)
      .subscribe(data => {
        this.reloadData();
      });
  }

  onUpdate(): void {
    if(this.editCatalog)
      this.catalogService.updateCatalog(this.editCatalog.id,this.editCatalog)
        .subscribe(data => {
          this.reloadData();
        });
  }


  onCreate() {
    // Vérifier que les propriétés du nouveau catalogue sont bien remplies
    if (!this.newCatalog.Libelle) {
      alert('Le nom du catalogue est requis');
      return;
    }

    // Appeler la méthode createCatalog du service de catalogue pour envoyer les données du nouveau catalogue à l'API
    this.catalogService.createCatalog(this.newCatalog)
      .subscribe(
        (response) => {
          // Si la réponse est positive, afficher un message de succès et récupérer la liste des catalogues mis à jour
          alert('Catalogue créé avec succès');
          this.catalogService.getCatalogsList().subscribe(
            (catalogs) => this.catalogs = catalogs
          );
        },
        (error) => {
          // Sinon, afficher un message d'erreur
          alert('Erreur lors de la création du catalogue');
        }
      );
  }

  gotoList(): void {
    //if(this.editCatalog) this.editCatalog = null;
    //if(this.selectedCatalog) this.selectedCatalog = null;
    this.newCatalog = new Catalog(0, "",[]);
  }
}

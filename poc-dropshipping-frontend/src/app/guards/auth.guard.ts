import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AppService } from 'app/app.service';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router, private service: AppService) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const currentUser = this.service.currentUserValue();

        if (currentUser) {
            return true;
        }

        this.router.navigate(['catalogo']);
        return false;
    }
}
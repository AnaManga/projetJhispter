import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { User, UserService } from 'app/core';
import { GroupService } from 'app/entities/group/group.service';
import { IGroup, Group } from 'app/shared/model/group.model';

@Component({
    selector: 'jhi-user-mgmt-update',
    templateUrl: './user-management-update.component.html'
})
export class UserMgmtUpdateComponent implements OnInit {
    user: User;
    languages: any[];
    authorities: any[];
    groups: IGroup[];
    isSaving: boolean;

    constructor(
        private userService: UserService,
        private groupService: GroupService,
        private route: ActivatedRoute,
        private router: Router
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.route.data.subscribe(({ user }) => {
            this.user = user.body ? user.body : user;
        });
        this.authorities = [];
        this.userService.authorities().subscribe(authorities => {
            this.authorities = authorities;
        });

        this.groupService.query().subscribe((res: HttpResponse<IGroup[]>) => {
            this.groups = res.body;
            //console.log(this.groups);
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.user.id !== null) {
            this.userService.update(this.user).subscribe(response => this.onSaveSuccess(response), () => this.onSaveError());
            console.log(this.user);
        } else {
            this.user.langKey = 'en';
            this.userService.create(this.user).subscribe(response => this.onSaveSuccess(response), () => this.onSaveError());
        }
    }

    private onSaveSuccess(result) {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

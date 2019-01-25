import { NgModule } from '@angular/core';

import { NewAppliSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [NewAppliSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [NewAppliSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class NewAppliSharedCommonModule {}

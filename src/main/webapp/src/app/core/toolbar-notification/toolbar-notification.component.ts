import { OnInit, Component, Input } from "@angular/core";

@Component({
    selector: 'app-toolbar-notification',
    templateUrl: './toolbar-notification.component.html',
    styleUrls: ['./toolbar-notification.component.css']
})
export class ToolbarNotificationComponent implements OnInit {
    @Input() notifications = [];
    
    constructor() {}

    ngOnInit() {

    }
}
import { Component, Input, EventEmitter, Output } from '@angular/core';
import { Task } from '../models/task.model';

@Component({
  selector: 'app-task-item',
  templateUrl: './task-item.component.html',
  styleUrls: ['./task-item.component.scss']
})
export class TaskItemComponent {

  @Input() task: Task;
  @Output() selectTask = new EventEmitter<Task>();
  @Output() performTask = new EventEmitter<Task>();

/* <app-task-item [task]="" (selectTask)="onSelect($event)"></app-task-item> */

  executeAction(action: string): void {
    this[action].emit(this.task);
  }
}

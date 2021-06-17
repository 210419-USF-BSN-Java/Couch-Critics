import { Component, Input, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserServiceService} from 'src/app/services/user-service.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-view-all-employees',
  templateUrl: './view-all-employees.component.html',
  styleUrls: ['./view-all-employees.component.css']
})
export class ViewAllEmployeesComponent implements OnInit {
  users: User[];

  editUser: User;

  deleteUser: User;


  constructor(private userService : UserServiceService) { }
  
  viewAllEmployees() {
    this.userService.getEmployees().subscribe(
      (response : User[]) => {
        this.users = response;
      }
    )
  }

  public onOpenModal(user: User, click: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (click === 'add') {
      button.setAttribute('data-target', '#addUserModal');
    } else if (click === 'edit') {
      this.editUser = user;
      button.setAttribute('data-target', '#updateUserModal');
    } else if (click === 'delete') {
      this.deleteUser = user;
      console.log(this.deleteUser);
      button.setAttribute('data-target', '#deleteUserModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddEmloyee(addForm): void {
    document.getElementById('add-employee-form')?.click();
    this.userService.addUser(addForm.value).subscribe(
      (response: User) => {
        this.viewAllEmployees();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onUpdateEmloyee(user: User): void {
    console.log(user);
    this.userService.updateUser(user).subscribe(
      (response: User) => {
        console.log(response);
        this.viewAllEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteEmloyee(userId: number): void {

    this.userService.deleteUser(userId).subscribe(
      (response: void) => {
        console.log(response);
        this.viewAllEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchEmployees(key: string): void {

    const results: User[] = [];
    for (const user of this.users) {
      if (user.firstName.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.lastName.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.roleId.role.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || user.statusid.accStatus.indexOf(key) !== -1) {
        results.push(user);
      }
    }
    this.users = results;

    //maybe i should delete the results.length === 0 so that it will show empty if they enter a name that does not exist.
    if (results.length === 0 || !key) {
      this.viewAllEmployees();
    }
  }

  ngOnInit(): void {
    this.viewAllEmployees();
  }

  // goBack(): void {
  //   this.location.back();
  // }

}

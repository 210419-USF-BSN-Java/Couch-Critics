import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllUsersComponent } from './view-all-users.component';

describe('ViewAllUsersComponent', () => {
  let component: ViewAllUsersComponent;
  let fixture: ComponentFixture<ViewAllUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAllUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

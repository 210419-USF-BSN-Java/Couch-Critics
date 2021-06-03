import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserLoggedInHomeComponent } from './user-logged-in-home.component';

describe('UserLoggedInHomeComponent', () => {
  let component: UserLoggedInHomeComponent;
  let fixture: ComponentFixture<UserLoggedInHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserLoggedInHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserLoggedInHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

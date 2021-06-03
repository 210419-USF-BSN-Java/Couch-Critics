import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewCriticsPageComponent } from './user-view-critics-page.component';

describe('UserViewCriticsPageComponent', () => {
  let component: UserViewCriticsPageComponent;
  let fixture: ComponentFixture<UserViewCriticsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewCriticsPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewCriticsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewCriticsContainerComponent } from './user-view-critics-container.component';

describe('UserViewCriticsContainerComponent', () => {
  let component: UserViewCriticsContainerComponent;
  let fixture: ComponentFixture<UserViewCriticsContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewCriticsContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewCriticsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

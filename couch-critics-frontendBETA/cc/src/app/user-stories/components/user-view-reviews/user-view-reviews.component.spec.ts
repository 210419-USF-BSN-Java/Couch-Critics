import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewReviewsComponent } from './user-view-reviews.component';

describe('UserViewReviewsComponent', () => {
  let component: UserViewReviewsComponent;
  let fixture: ComponentFixture<UserViewReviewsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewReviewsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewReviewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

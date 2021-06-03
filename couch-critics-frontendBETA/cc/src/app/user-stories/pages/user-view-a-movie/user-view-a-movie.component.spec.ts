import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewAMovieComponent } from './user-view-a-movie.component';

describe('UserViewAMovieComponent', () => {
  let component: UserViewAMovieComponent;
  let fixture: ComponentFixture<UserViewAMovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewAMovieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewAMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

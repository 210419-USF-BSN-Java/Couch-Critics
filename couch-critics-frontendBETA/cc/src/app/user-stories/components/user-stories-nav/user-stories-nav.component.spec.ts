import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserStoriesNavComponent } from './user-stories-nav.component';

describe('UserStoriesNavComponent', () => {
  let component: UserStoriesNavComponent;
  let fixture: ComponentFixture<UserStoriesNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserStoriesNavComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserStoriesNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

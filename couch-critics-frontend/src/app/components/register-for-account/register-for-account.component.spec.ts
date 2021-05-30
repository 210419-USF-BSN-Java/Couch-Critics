import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterForAccountComponent } from './register-for-account.component';

describe('RegisterForAccountComponent', () => {
  let component: RegisterForAccountComponent;
  let fixture: ComponentFixture<RegisterForAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterForAccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterForAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

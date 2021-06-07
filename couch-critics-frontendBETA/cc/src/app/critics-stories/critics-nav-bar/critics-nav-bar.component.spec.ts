import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriticsNavBarComponent } from './critics-nav-bar.component';

describe('CriticsNavBarComponent', () => {
  let component: CriticsNavBarComponent;
  let fixture: ComponentFixture<CriticsNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CriticsNavBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CriticsNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
